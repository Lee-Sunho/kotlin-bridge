package bridge.view

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    private val outputView = OutputView()

    init {
        outputView.printStart()
    }

    fun readBridgeSize(): Int {
        outputView.printInputBridgeLength()
        val length = Console.readLine()
        // 유효성 검사
        return length.toInt()
    }

    fun readMoving(): String {
        outputView.printInputMoving()
        val moving = Console.readLine()
        // 유효성 검사
        return moving
    }

    fun readGameCommand(): String {
        outputView.printInputRetry()
        val retry = Console.readLine()
        // 유효성 검사
        return retry
    }
}
