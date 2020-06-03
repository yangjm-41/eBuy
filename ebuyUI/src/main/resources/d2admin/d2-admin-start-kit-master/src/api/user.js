import request from 'axios'

export function getUserInfo () {
  return request({
    url: '/users/info',
    method: 'get'
  })
}
