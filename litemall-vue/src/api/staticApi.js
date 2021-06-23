import request from '@/utils/staticRequest'

export function getDepartment() {
    return request({
        url: '/sample/home/department.json',
        method: 'get'
    })
}

export function getGoodDoctors() {
    return request({
        url: '/sample/goodDoctors/goodDoctors.json',
        method: 'get'
    })
}

export function getSkinDoctors() {
    return request({
        url: '/sample/skinDoctors/skinDoctors.json',
        method: 'get'
    })
}

export function getArticles() {
    return request({
        url: '/sample/articles/articles.json',
        method: 'get'
    })
}