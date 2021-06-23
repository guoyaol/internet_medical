<template>
    <div>
      
        <h1 align="center">预约界面</h1>
        <div>
             <van-field v-model="name"
                   name="姓名"
                   label="姓名"
                   placeholder="姓名"
                   :rules="[{required:true,message:'请填写姓名'}]"
                   @input="getFieldValue"
                   />
              <van-field v-model="age"
                   name="年龄"
                   label="年龄"
                   placeholder="年龄"
                   :rules="[{required:true,message:'请填写年龄'}]"
                   />
        </div>
        <div>
             <van-field name="radio" label="性别">
                <template #input>
                    <van-radio-group v-model="radio" direction="horizontal">
                    <van-radio name="1">男</van-radio>
                    <van-radio name="2">女</van-radio>
                    </van-radio-group>
                </template>
                </van-field>
        </div>
        <div>
                <van-field class="text1" size="large" v-model="message" rows="2" autosize label="症状"
                     type="textarea" maxlength="150" placeholder="请输入症状" show-word-limit/>
        </div>
        <div>
            <van-cell title="选择预约日期" :value="date" @click="show = true" />
            <van-calendar v-model="show" @confirm="onConfirm" />
            <van-datetime-picker v-model="currentTime" type="time" title="选择时间" :min-hour="10" :max-hour="20"/>
        </div>
        <div>
            <van-button type="info" size="large" @click="showConfirm()"> 提交按钮</van-button>
        </div>
        
    </div>
</template>

<script>
import Vue from 'vue';
import { Form } from 'vant';
import { Field } from 'vant';
import { Calendar } from 'vant';
import { Dialog } from 'vant';
import { RadioGroup, Radio } from 'vant';
import { DatetimePicker } from 'vant';

Vue.use(DatetimePicker);
Vue.use(Radio);
Vue.use(RadioGroup);
Vue.use(Dialog);
Vue.use(Calendar);
Vue.use(Form);
Vue.use(Field);

export default {
  data() {
    return {
      value: '',
      showPicker: false,
      date:'',
      show:false,
      radio:'1',
      currentTime:'12:00',
      fieldValue:'',
      name:'',
      age:'',
      message:''
    }
  },

  methods: {
    getFieldValue(e){
       console.log(e)
       this.fieldValue=e.detail
    },
    onConfirm(time) {
      this.value = time;
      this.showPicker = false;
    },
    formatDate(date){
        return `${date.getMonth() + 1}/${date.getDate()}`;
    },
    onConfirm(date)
    {
        this.show=false;
        this.date=this.formatDate(date);
    },
    changeSuccess()
    {
        this.$router.push({
        name: 'success'
      });
    },
    //this.$router.push({
    //    name:'success'
    //  });
    showConfirm() {
        Dialog.alert({
            title: '预约提示',
            message: '预约成功',
        }).then(() => {
            this.$router.go(-1)
        });
    }
  },
  components:{
   [Dialog.Component.name]:Dialog.Component,
  },
};
</script>
