const Tabbar = () => import('@/components/Tabbar/');

export default [
  {
    path: '/',
    name: 'home',
    components: {
      default: () => import('@/views/home/tabbar-home'),
      tabbar: Tabbar
    },
    meta: {
      keepAlive: true,
      showHeader:false
    },
  },
  {
    path: '/home/doctor',
    name: 'doctor',
    components: {
      default: () => import('@/views/home/doctor')
    }
  },
  {
    path: '/home/article',
    name: 'article',
    components: {
      default: () => import('@/views/home/article')
    }
  },
  {
    path:'/home/appointment',
    name:'appointment',
    components:{
      default:() => import('@/views/home/appointment')
    }
  },
  {
    path: '*',
    redirect: {
      name: 'home'
    }
  }
];
