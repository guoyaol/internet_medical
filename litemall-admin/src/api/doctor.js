// import request from '@/utils/request'

// export function fetchList(query) {
//   return request({
//     url: '/doctor/list',
//     method: 'get',
//     params: query
//   })
// }

// export function doctorDetail(id) {
//   return request({
//     url: '/doctor/detail',
//     method: 'get',
//     params: {id}
//   })
// }

// export function updateDoctor(data) {
//   return request({
//     url: '/user/update',
//     method: 'post',
//     data
//   })
// }

import request from '@/utils/staticRequest'

export function fetchList(query) {
  return request({
    url: '/sample/doctor/doctor.json',
    method: 'get',
    params: ''
  })
}
