<template>
  <div class="tab_home">
    <div class="tal_class_searchBox">
      <van-search placeholder="点击前往搜索"
                  @click="$router.push({ name: 'search' })" />
      <div class="tal_class_searchMask"></div>
    </div>

    <!-- <div class="goods-channel">
      <div class="item"
           @click="changeTabbar(channel)"
           v-for="(channel, index) in shopInfos.channel"
           :key="index">
        <img :src="channel.iconUrl"
             background-size="cover" />
        <span>{{channel.name}}</span>
      </div>
    </div> -->

    <van-panel title="按科室查找">
      <div class="goods-channel">
        <div class="item"
           @click="changeDepartment()"
            v-for="(department, index) in departmentInfos.list"
            :key="index">
          <img :src="department.iconUrl"
              background-size="cover" />
          <span style="font-size:10px">{{department.name}}</span>
        </div>
      </div>
    </van-panel>

    <van-panel title="资深名医">
      <div v-for="(goodDoctor, index) in goodDoctors.list" :key="index">
        <div class="mingpian" style="padding: 8px;">
          <div class="picture">
            <img :src="goodDoctor.avatar"
                class="image">
          </div>
          <div class="introduction">
            <h3>医生：{{goodDoctor.name}}</h3>
            <p> {{goodDoctor.description}}</p>
            <div class="bottom clearfix">
              <br>
              <van-button type="info" @click="changeAppointment()">立即预约</van-button>
            </div>
          </div>
        </div>
      </div>
    </van-panel>
    
    <van-panel title="优质科普">
      <van-swipe :autoplay="3000"
                indicator-color="white">
        <van-swipe-item v-for="(article, index) in articles.list"
                        :key="index"
                        @click="gotoArticle()">
          <img :src="article.title"
              style="height:180px">
        </van-swipe-item>
      </van-swipe>
    </van-panel>


  </div>
</template>

<script>
import { getHome, goodsCategory, couponReceive } from '@/api/api';
import { getDepartment, getGoodDoctors, getArticles } from '@/api/staticApi';
import scrollFixed from '@/mixin/scroll-fixed';
import _ from 'lodash';

import {
  List,
  Swipe,
  SwipeItem,
  Tabbar,
  TabbarItem,
  Search,
  Panel,
  CouponCell,
  CouponList,
  Toast,
  Card,
  Grid,
  GridItem,
  Row,
  Col,
  Tag,
  Button,
  Cell
} from 'vant';

export default {
  mixins: [scrollFixed],

  data() {
    return {
      shopInfos: [],
      departmentInfos: [],
      goodDoctors: [],
      articles: [],
      isLoading: false
    };
  },

  created() {
    this.initViews();
  },

  methods: {
    goDetail(id) {
      return `#/items/detail/${id}`;
    },
    goBrand(id) {
      return `#/items/brand/${id}`;
    },
    goTopic(id) {
      return `#/items/topic/${id}`;
    },    
    getCoupon(id) {
      couponReceive({ couponId: id }).then(res => {
        Toast.success('领取成功');
      });
    },
    changeTabbar(o) {
      goodsCategory({ id: o.id }).then(res => {
        let categoryId = res.data.data.currentCategory.id;
        console.log(o.id);
        console.log(categoryId);
        this.$router.replace({
          name: 'category',
          query: { itemClass: categoryId }
        });
      });
    },
    changeDepartment() {
      this.$router.push({
        name: 'doctor'
      });
    },
    initViews() {
      getHome().then(res => {
        console.log("getHome data data")
        console.log(res.data.data);
        this.shopInfos = res.data.data;
      });
      getDepartment().then(res => {
        this.departmentInfos = res.data.data;
      });
      getGoodDoctors().then(res => {
        this.goodDoctors = res.data.data;
      });
      getArticles().then(res => {
        this.articles = res.data.data;
      });
    },   
    changeAppointment(){
      this.$router.push({
        name:'appointment'
      });
    },
    gotoArticle() {
      this.$router.push({
        name: 'article'
      });
    }
  },

  components: {
    [Row.name]: Row,
    [Col.name]: Col,
    [Card.name]: Card,
    [Toast.name]: Toast,
    [CouponCell.name]: CouponCell,
    [CouponList.name]: CouponList,
    [Search.name]: Search,
    [Panel.name]: Panel,
    [List.name]: List,
    [Swipe.name]: Swipe,
    [SwipeItem.name]: SwipeItem,
    [Tabbar.name]: Tabbar,
    [TabbarItem.name]: TabbarItem,
    [Tag.name]: Tag,
    [Grid.name]: Grid,
    [GridItem.name]: GridItem
  }
};
</script>


<style lang="scss" scoped>
.interval_bot {
  margin-bottom: 10px;
}
.van-panel {
  margin-top: 20px;
}
.goods-channel {
  background: #fff;
  display: flex;
  align-items: center;
  flex-wrap: wrap;
  padding-bottom: 0px;
  padding-top: 10px;
}

.goods-channel .item {
  width: 50px;
  height: 50px;
  margin-left: 10px;
}

.goods-channel img {
  display: block;
  width: 20px;
  height: 20px;
  margin: 0 auto;
}

.goods-channel span {
  display: block;
  font-size: 14px;
  text-align: center;
  margin-top: 5px;
  margin-bottom: 10px;
  color: #333;
}
.van-coupon-cell--selected {
  color: #323233;
}
.van-coupon-list {
  height: 100%;
  position: relative;
  background-color: #f8f8f8;
}
.van-coupon-list__field {
  padding: 7px 15px;
}
.van-coupon-list__exchange {
  height: 32px;
  line-height: 30px;
}
.van-coupon-list__list {
  overflow-y: auto;
  padding: 15px 0;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-overflow-scrolling: touch;
}
.van-coupon-list__close {
  left: 0;
  bottom: 0;
  position: absolute;
  font-weight: 500;
}
.van-coupon-list__empty {
  padding-top: 100px;
  text-align: center;
}
.van-coupon-list__empty p {
  color: #969799;
  margin: 15px 0;
  font-size: 14px;
  line-height: 20px;
}
.van-coupon-list__empty img {
  width: 80px;
  height: 84px;
}
.van-coupon-item {
  overflow: hidden;
  border-radius: 4px;
  margin: 0 15px 15px;
  background-color: #fff;
  -webkit-box-shadow: 0 0 4px rgba(0, 0, 0, 0.1);
  box-shadow: 0 0 4px rgba(0, 0, 0, 0.1);
}
.van-coupon-item:active {
  background-color: #e8e8e8;
}
.van-coupon-item__content {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  height: 100px;
  padding: 24px 0 0 15px;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  border: 1px solid red;
}
.van-coupon-item h2,
.van-coupon-item p {
  margin: 0;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
.van-coupon-item h2 {
  height: 34px;
  font-weight: 500;
  line-height: 34px;
}
.van-coupon-item p {
  font-size: 12px;
  line-height: 16px;
  color: #969799;
}
.van-coupon-item__head {
  min-width: 90px;
}
.van-coupon-item__head h2 {
  color: #f44;
  font-size: 24px;
}
.van-coupon-item__head h2 span {
  font-size: 50%;
}
.van-coupon-item__body {
  -webkit-box-flex: 1;
  -ms-flex: 1;
  flex: 1;
  position: relative;
  border-radius: 0 4px 4px 0;
}
.van-coupon-item__body h2 {
  font-size: 16px;
}
.van-coupon-item__corner {
  top: 16px;
  right: 15px;
  position: absolute;
}
.van-coupon-item__corner .van-icon {
  border-color: #f44;
  background-color: #f44;
}
.van-coupon-item__reason {
  padding: 7px 15px;
  border-top: 1px dashed #ebedf0;
  background-color: #fafafa;
}
.van-coupon-item--disabled:active {
  background-color: #fff;
}
.van-coupon-item--disabled .van-coupon-item__content {
  height: 90px;
}
.van-coupon-item--disabled h2,
.van-coupon-item--disabled p,
.van-coupon-item--disabled span {
  color: #969799;
}

.bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

.mingpian{
  width:350px;margin:20px auto;border:solid 1px black;
  overflow:hidden;
}

.picture{
  width:140px;
  float:left;
} 
  
.introduction{
  float:right;
  width:150px;
}
  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
  
  .clearfix:after {
      clear: both
  }
</style>
