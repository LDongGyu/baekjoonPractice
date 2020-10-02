class Solution {
    fun solution(num: Int): String {
        if(num%2 == 0) return "Even"
        else return "Odd"
    }
}

fun main() {
    var sol = Solution()

    print(sol.solution(3))
}