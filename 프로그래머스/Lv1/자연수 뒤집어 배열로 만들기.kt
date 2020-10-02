class Solution {
    fun solution(n: Long): IntArray {
        var answer = mutableListOf<Int>()
        var num = n

        while(num > 0){
            answer.add((num%10).toInt())
            num /= 10
        }

        return answer.toIntArray()
    }
}

fun main() {
    var sol = Solution()

    print(sol.solution(12345))

}