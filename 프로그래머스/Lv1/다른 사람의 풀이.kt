class Solution {
    fun solution(num: Int): Int {
        var answer = 0
        var n:Long = num.toLong()

        while(n != 1.toLong()){
            if(answer>500) return -1
            if(n%2 == 0.toLong()) n /= 2
            else n = (n*3)+1
            answer++
        }

        return answer
    }
}

fun main() {
    var sol = Solution()

    print(sol.solution(10))
}