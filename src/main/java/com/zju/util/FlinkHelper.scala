package com.zju.util

import org.apache.flink.api.common.restartstrategy.RestartStrategies
import org.apache.flink.streaming.api.{CheckpointingMode, TimeCharacteristic}
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

object FlinkHelper {

    def getEnv(paraller:Int,tc:TimeCharacteristic):StreamExecutionEnvironment={
        val environment: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
        environment.setStreamTimeCharacteristic(tc)
        environment.setParallelism(paraller)
        environment.setRestartStrategy(RestartStrategies.fixedDelayRestart(Constants.MAX_FAILUR_RESTART_ACCEPTES,Constants.MAX_DELAY_INTERVAL))
        environment.enableCheckpointing(Constants.CHECKPOINT_INTERVAL,CheckpointingMode.EXACTLY_ONCE)
        environment.getConfig.setAutoWatermarkInterval(Constants.WATERMARK_INTERVAL)
        environment
    }

    def getEnv():StreamExecutionEnvironment={
        getEnv(Constants.MAX_CURRENT_PARALLE,TimeCharacteristic.EventTime)
    }

}
