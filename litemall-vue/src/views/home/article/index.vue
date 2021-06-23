<template>
  <div>
    <img :src="articles.list[0].content" style="width:360px" v-if="articles.list" />
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
    initViews() {
      getHome().then(res => {
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

.bottom {
    margin-top: 13px;
    line-height: 12px;
  }

</style>
