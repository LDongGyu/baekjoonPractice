import java.util.*

class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = IntArray(commands.size)

        for(i in 0..answer.size-1){
            var tempArray = array.slice(commands[i][0]-1..commands[i][1]-1)
            tempArray = tempArray.sorted()
            answer[i] = tempArray[commands[i][2]-1]
        }

        return answer
    }
}

//class Solution {
//    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
//        return commands.map { command ->
//            array.slice(IntRange(command[0] - 1, command[1] - 1)).sorted()[command[2] - 1]
//        }
//                .toIntArray()
//    }
//}

fun main(){
    var sol = Solution()
//    var result= sol.solution(arrayOf(1,5,2,6,3,7,4),listOf<IntArray>(intArrayOf(2,5,3),intArrayOf(4,4,1),intArrayOf(1,7,3)))

//    print(result)
}