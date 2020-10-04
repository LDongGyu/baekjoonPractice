class Solution {
    fun solution(phone_number: String): String {
        var answer = ""
        for (i in 0..phone_number.lastIndex-4){
            answer += '*'
        }
        answer += phone_number.substring(phone_number.lastIndex-3)
        return answer
    }
}

fun main() {
    var sol = Solution()

    print(sol.solution(2,5))
}