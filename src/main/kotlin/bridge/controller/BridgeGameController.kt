package bridge.controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.model.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

class BridgeGameController {
    val inputView = InputView()
    val outputView = OutputView()
    val bridgeGame = BridgeGame()
    private val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
    val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)

    fun play() {
        val length = inputView.readBridgeSize()
        bridgeMaker.makeBridge(length)
        val moving = inputView.readMoving()
        
    }
}