class Solution {
    fun solution(w: Int, h: Int): Long {
        var answer: Long = 0

        for(i in 0..w-1){
            answer += h.toLong() * i / w.toLong()
        }

        return answer*2
    }
}

fun main() {
    var sol = Solution()

    print(sol.solution(8,12))
}