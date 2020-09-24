class Solution {

    var month = arrayOf(31,29,31,30,31,30,31,31,30,31,30,31)
    var day = arrayOf("FRI","SAT","SUN","MON","TUE","WED","THU")

    fun solution(a: Int, b: Int): String {
        var answer = ""
        var cnt = 0

        for(i in 0.. a-2){
            cnt += month[i]
        }
        cnt += b
        cnt--
        cnt = cnt%7

        answer = day[cnt]

        return answer
    }
}

fun main() {
    var sol = Solution()

    var result = sol.solution(5,24)

    print(result)
}