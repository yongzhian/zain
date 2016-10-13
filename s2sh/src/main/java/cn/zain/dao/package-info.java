/**
 * Created by Zain on 2016/9/17.
 * 持久层操作
 * 为解耦，防止hibernate升级导致兼容性操作，不建议直接继承HibernateDaoSupport, 故聚合一个hibernateTemplet，放于base下，其他dao继承
 *
 */
package cn.zain.dao;