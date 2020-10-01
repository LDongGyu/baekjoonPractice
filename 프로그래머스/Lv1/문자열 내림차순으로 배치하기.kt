class Solution {
    fun solution(s: String): String {
        var answer = ""

        var list = s.toMutableList().sorted()
        list.reversed().forEach {
            answer += it
        }

        return answer
    }
}

fun main() {
    var sol = Solution()

    var result = sol.solution("Zbcdefg")

    print(result)
}