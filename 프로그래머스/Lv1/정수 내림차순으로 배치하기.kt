class Solution {
    fun solution(n: Long): Long {
        var answer = ""
        n.toString()
            .toMutableList()
            .sorted()
            .reversed()
            .forEach {
                answer += it
            }

        return answer.toLong()
    }
}

fun main() {
    var sol = Solution()

    print(sol.solution(118372))
}