class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        var fi = LongArray(n+1)
        fi[1] = 1

        for(i in 2..n){
            fi[i] = fi[i-2]%1234567 + fi[i-1]%1234567
        }
        answer = (fi[n]% 1234567).toInt()
        return answer
    }
}

fun main() {
    var sol = Solution()

    var result = sol.solution(100)

    print(result)
}