import { uniqueId } from 'lodash'

/**
 * @description 给菜单数据补充上 path 字段
 * @description https://github.com/d2-projects/d2-admin/issues/209
 * @param {Array} menu 原始的菜单数据
 */
function supplementPath (menu) {
  return menu.map(e => ({
    ...e,
    path: e.path || uniqueId('d2-menu-empty-'),
    ...e.children ? {
      children: supplementPath(e.children)
    } : {}
  }))
}

export const menuHeader = supplementPath([
  { path: '/index', title: '首页', icon: 'home' },
  {
    title: '我的空间',
    icon: 'folder-o',
    children: [
      { path: '/userInfo', title: '用户信息' },
      { path: '/addrsManagement', title: '地址管理' },
      { path: '/registerAsBusiness', title: '注册为商家' },
      { path: '/updatePassword', title: '修改密码' }
    ]
  },
  {
    title: '购物车',
    icon: 'folder-o',
    path: '/shoppingCar'
  },
  {
    title: '评价管理',
    icon: 'folder-o',
    path: '/evaluationManagement'
  },
  {
    title: '我的商品',
    icon: 'folder-o',
    children: [
      { path: '/productList', title: '商品列表' }
    ]
  }
])

export const menuAside = supplementPath([
  { path: '/index', title: '首页', icon: 'home' },
  {
    title: '我的空间',
    icon: 'folder-o',
    children: [
      { path: '/userInfo', title: '用户信息' },
      { path: '/addrsManagement', title: '地址管理' },
      { path: '/registerAsBusiness', title: '注册为商家' },
      { path: '/updatePassword', title: '修改密码' }
    ]
  },
  {
    title: '购物车',
    icon: 'folder-o',
    path: '/shoppingCar'
  },
  {
    title: '评价管理',
    icon: 'folder-o',
    path: '/evaluationManagement'
  },
  {
    title: '我的商品',
    icon: 'folder-o',
    children: [
      { path: '/productList', title: '商品列表' }
    ]
  }
])
