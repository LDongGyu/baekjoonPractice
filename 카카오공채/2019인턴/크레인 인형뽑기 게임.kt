import java.util.*

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        var stack = Stack<Int>()

        for(move in moves) {
            var top = top(move-1,board)
            if(top == -1) continue
            else if(stack.isEmpty()) stack.add(top)
            else if(stack.peek() == top){
                answer += 2
                stack.pop()
            }
            else stack.add(top)
        }

        return answer
    }

    fun top(index: Int, board: Array<IntArray>): Int{
        var top = -1

        for(i in 0..board.lastIndex){
            if(board[i][index] != 0){
                top = board[i][index]
                board[i][index] = 0
                break
            }
        }

        return top
    }
}

fun main() {
    var sol = Solution()

    print(sol.solution(arrayOf(intArrayOf(0,0,0,0,0), intArrayOf(0,0,1,0,3),
            intArrayOf(0,2,5,0,1), intArrayOf(4,2,4,4,2), intArrayOf(3,5,1,3,1)), intArrayOf(1,5,3,5,1,2,1,4)))
}