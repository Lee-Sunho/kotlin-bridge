package bridge.view

import bridge.constants.Constant.Companion.MAX_BRIDGE_LENGTH
import bridge.constants.Constant.Companion.MIN_BRIDGE_LENGTH
import bridge.constants.Exception.Companion.EXCEPTION_INVALID_MOVING
import bridge.constants.Exception.Companion.EXCEPTION_INVALID_RANGE_NUMBER
import bridge.constants.Exception.Companion.EXCEPTION_INVALID_RETRY
import bridge.constants.Exception.Companion.EXCEPTION_IS_NOT_NUMBER
import bridge.constants.String.Companion.STRING_DOWN
import bridge.constants.String.Companion.STRING_QUIT
import bridge.constants.String.Companion.STRING_RETRY
import bridge.constants.String.Companion.STRING_UP
import camp.nextstep.edu.missionutils.Console

class InputView {
    private val outputView = OutputView()

    init {
        outputView.printStart()
    }

    fun readBridgeSize(): Int {
        outputView.printInputBridgeLength()
        val length = Console.readLine()
        checkBridgeLength(length)
        return length.toInt()
    }

    private fun checkBridgeLength(length: String) {
        validateIsNumber(length)
        validateNumberRange(length)
    }

    private fun validateIsNumber(input: String) {
        if (!input.all { Character.isDigit(it) }) {
            outputView.printException(EXCEPTION_IS_NOT_NUMBER)
            throw  IllegalArgumentException(EXCEPTION_IS_NOT_NUMBER)
        }
    }
    private fun validateNumberRange(input: String) {
        if (input.toInt() < MIN_BRIDGE_LENGTH || input.toInt() > MAX_BRIDGE_LENGTH) {
            outputView.printException(EXCEPTION_INVALID_RANGE_NUMBER)
            throw  IllegalArgumentException(EXCEPTION_INVALID_RANGE_NUMBER)
        }
    }

    fun readMoving(): String {
        outputView.printInputMoving()
        val moving = Console.readLine()
        checkMoving(moving)
        return moving
    }

    private fun checkMoving(moving: String) {
        val valid = listOf<String>(STRING_UP, STRING_DOWN)
        if (!valid.contains(moving)) {
            outputView.printException(EXCEPTION_INVALID_MOVING)
            throw  IllegalArgumentException(EXCEPTION_INVALID_MOVING)
        }
    }

    fun readGameCommand(): String {
        outputView.printInputRetry()
        val retry = Console.readLine()
        checkRetry(retry)
        return retry
    }

    private fun checkRetry(retry: String) {
        val valid = listOf<String>(STRING_RETRY, STRING_QUIT)
        if (!valid.contains(retry)) {
            outputView.printException(EXCEPTION_INVALID_RETRY)
            throw  IllegalArgumentException(EXCEPTION_INVALID_RETRY)
        }
    }
}
