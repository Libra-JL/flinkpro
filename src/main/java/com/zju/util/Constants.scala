package com.zju.util

object Constants {
    //设置flink的上下文环境变量相关参数
    val MAX_FAILUR_RESTART_ACCEPTES = 3
    val MAX_DELAY_INTERVAL = 5
    val MAX_CURRENT_PARALLE = Runtime.getRuntime.availableProcessors
    val CHECKPOINT_INTERVAL = 10
    val WATERMARK_INTERVAL = 5*1000

}
