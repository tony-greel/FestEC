package com.diabin.festec.latte_core.app;


/**
 * 在程序中只能被初始化一次
 * 在整个应用程序中是唯一单例
 * 可进行多线程懒汉模式操作
 */
public enum ConfigKeys {
    API_HOST, //配置网络请求域名
    APPLICATION_CONTEXT, //全局的上下文
    CONFIG_READY, //检查配置是否完成
    ICON //字体初始化
}