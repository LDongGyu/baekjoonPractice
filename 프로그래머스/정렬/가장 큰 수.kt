import java.util.*

class Solution {
    fun solution(numbers: IntArray): String {
        var answer = ""

        numbers.sortedWith(Comparator({ o1, o2 ->
            "$o2$o1".compareTo("$o1$o2")
        })).forEach({answer += it})

        if(answer[0].equals('0')) answer = "0"

        return answer
    }
}

fun main(){
    var sol = Solution()
    var result= sol.solution(intArrayOf(6,10,2))

    print(result)
}