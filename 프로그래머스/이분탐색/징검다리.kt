class Solution {
    fun solution(distance: Int, rocks: IntArray, n: Int): Int {
        var answer = 0

        var left = 1
        var right = distance
        var mid = (left+right)/2

        rocks.sort()

        while(left <= right){
            var cnt = 0
            var prev = 0
            mid = (left+right)/2

            rocks.forEach {
                if(Math.abs(it - prev) < mid) cnt++
                else prev = it
            }

            if(distance - prev < mid) cnt++

            if(cnt <= n){
                if(answer < mid) answer = mid
                left = mid+1
            }
            else right = mid-1
        }

        return answer
    }
}

fun main() {
    var sol = Solution()

    var result = sol.solution(25,intArrayOf(2,14,11,21,17),2)

    print(result)
}