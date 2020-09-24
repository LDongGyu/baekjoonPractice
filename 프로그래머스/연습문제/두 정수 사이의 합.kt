class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0
        var newA = a
        var newB = b

        if(a > b){
            newA = b
            newB = a
        }

        for(i in newA..newB){
            answer += i
        }

        return answer
    }
}

fun main() {
    var sol = Solution()

    var result = sol.solution(3,5)

    print(result)
}