class Solution {
    fun solution(n: Int, times: IntArray): Long {

        var left:Long = 1
        var right:Long = times.max()!!.times(n).toLong()
        var mid:Long = right/2
        var answer: Long = right

        while(left <= right){
            mid = (left+right)/2
            var cnt:Long = 0
            for(i in 0..times.lastIndex){
                cnt += mid/times[i]
            }

            if(n > cnt){
                left = mid+1
            }
            else{
                if(mid <= answer) answer = mid;
                right = mid-1
            }
        }

        return answer
    }
}

fun main() {
    var sol = Solution()

    var result0 = sol.solution(6, intArrayOf(7,10))

    print(result0)
}

