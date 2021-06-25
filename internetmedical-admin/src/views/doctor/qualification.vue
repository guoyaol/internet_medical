<template>
  <div class="app-container">

    <!-- 查询和其他操作 -->
    <div class="filter-container">
      <el-input v-model="listQuery.username" clearable class="filter-item" style="width: 200px;" placeholder="请输入用户名" />
      <el-input v-model="listQuery.userId" clearable class="filter-item" style="width: 200px;" placeholder="请输入用户Id" />
      <el-input v-model="listQuery.mobile" clearable class="filter-item" style="width: 200px;" placeholder="请输入手机号" />

      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查找</el-button>
      <el-button :loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download" @click="handleDownload">导出</el-button>
    </div>

    <el-row>
      <el-button>全部</el-button>
      <el-button type="primary">未审核</el-button>
      <el-button type="success">审核通过</el-button>
      <el-button type="danger">审核未通过</el-button>
    </el-row>

    <p />

    <!-- 查询结果 -->
    <el-table v-loading="listLoading" :data="list" element-loading-text="正在查询中。。。" border fit highlight-current-row>
      <el-table-column align="center" width="100px" label="医生ID" prop="id" sortable />

      <el-table-column align="center" label="姓名" prop="name" width="80" />

      <el-table-column align="center" label="头像" width="80">
        <template slot-scope="scope">
          <el-avatar :src="scope.row.avatar" />
        </template>
      </el-table-column>

      <el-table-column align="center" label="手机号码" prop="mobile" />

      <el-table-column align="center" label="性别" prop="gender" width="80">
        <template slot-scope="scope">
          <el-tag>{{ genderDic[scope.row.gender] }}</el-tag>
        </template>
      </el-table-column>

      <el-table-column align="center" label="地址" prop="address" />
      <el-table-column align="center" label="医院" prop="hospital" />
      <el-table-column align="center" label="科室" prop="department" width="80" />
      <el-table-column align="center" label="简介" prop="description" width="300" />

      <el-table-column align="center" label="审核结果" prop="status" width="80">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.qualification === 0">{{ reviewDic[scope.row.qualification] }}</el-tag>
          <el-tag v-if="scope.row.qualification === 1" type="success">{{ reviewDic[scope.row.qualification] }}</el-tag>
          <el-tag v-if="scope.row.qualification === 2" type="danger">{{ reviewDic[scope.row.qualification] }}</el-tag>
        </template>
      </el-table-column>

      <el-table-column align="center" label="操作" width="80" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="handleReview(scope.row)">审核</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />
    <!-- 审核对话框 -->
    <el-dialog :visible.sync="reviewDialogVisible" title="资质审核">
      <el-form ref="userDetail" :model="userDetail" status-icon label-position="left" label-width="100px" style="width: 400px; margin-left:50px;">
        <el-form-item label="医生ID">
          <span>{{ userDetail.id }}</span>
        </el-form-item>
        <el-form-item label="姓名">
          <span>{{ userDetail.name }}</span>
        </el-form-item>
        <el-form-item label="手机号">
          <span>{{ userDetail.mobile }}</span>
        </el-form-item>
        <el-form-item label="性别">
          <span>{{ genderDic[userDetail.gender] }}</span>
        </el-form-item>
        <el-form-item label="地址">
          <span>{{ userDetail.address }}</span>
        </el-form-item>
        <el-form-item label="医院">
          <span>{{ userDetail.hospital }}</span>
        </el-form-item>
        <el-form-item label="科室">
          <span>{{ userDetail.department }}</span>
        </el-form-item>
        <el-form-item label="简介">
          <span>{{ userDetail.description }}</span>
        </el-form-item>

        <div>
          <h4>认证材料</h4>
          <img class="img" width="100%" :src="userDetail.material">
          <p />
        </div>

        <div>
          <h3>审核结果</h3>
          <template>
            <el-radio v-model="reviewOption" label="1">通过</el-radio>
            <el-radio v-model="reviewOption" label="2">驳回</el-radio>
          </template>
        </div>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="reviewDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="handleReviewUpdate">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { fetchList, userDetail, updateUser } from '@/api/doctor'
// import axios from 'axios'
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination

export default {
  name: 'User',
  components: { Pagination },
  data() {
    return {
      list: null,
      listTodo: null,
      listPass: null,
      listFail: null,
      total: 0,
      listLoading: true,
      listQuery: {
        page: 1,
        limit: 20,
        username: undefined,
        mobile: undefined,
        userId: undefined,
        sort: 'add_time',
        order: 'desc'
      },
      downloadLoading: false,
      genderDic: ['未知', '男', '女'],
      levelDic: ['普通用户', 'VIP用户', '高级VIP用户'],
      statusDic: ['可用', '禁用', '注销'],
      reviewDic: ['未审核', '审核通过', '审核未通过'],
      reviewDialogVisible: false,
      userDetail: {
      },
      materialWindowVisible: false,
      material: {
      },
      reviewOption: '0'
    }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      this.listLoading = true
      if (this.listQuery.userId) {
        userDetail(this.listQuery.userId).then(response => {
          this.list = []
          console.log(response.data)
          if (response.data.data) {
            this.list.push(response.data.data)
            this.total = 1
            this.listLoading = false
          } else {
            this.list = []
            this.total = 0
            this.listLoading = false
          }
        }).catch(() => {
          this.list = []
          this.total = 0
          this.listLoading = false
        })
      } else {
        fetchList(this.listQuery).then(response => {
          this.list = response.data.data.list
          this.total = response.data.data.total
          this.listLoading = false
          console.log(response.data)
        }).catch(() => {
          this.list = []
          this.total = 0
          this.listLoading = false
        })
      }
      console.log(this.list)
    },
    handleFilter() {
      this.listQuery.page = 1
      this.getList()
    },
    handleDownload() {
      this.downloadLoading = true
      import('@/vendor/Export2Excel').then(excel => {
        const tHeader = ['用户名', '手机号码', '性别', '生日', '状态']
        const filterVal = ['username', 'mobile', 'gender', 'birthday', 'status']
        excel.export_json_to_excel2(tHeader, this.list, filterVal, '用户信息')
        this.downloadLoading = false
      })
    },
    handleReview(row) {
      this.userDetail = row
      this.reviewDialogVisible = true
    },
    handleReviewUpdate() {
      updateDoctor(this.userDetail)
        .then((response) => {
          this.userDialogVisible = false
          this.$notify.success({
            title: '成功',
            message: '审核成功'
          })
        })
        .catch(response => {
          this.$notify.error({
            title: '失败',
            message: response.data.errmsg
          })
        })
    }
  }
}
</script>
