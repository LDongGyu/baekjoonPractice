class Solution {
    fun solution(arr: IntArray): Int {
        var answer = arr.max() ?: 0

        while(true){
            var cnt = 0
            arr.forEach {
                if(answer % it == 0){
                    cnt++
                }
            }
            if(cnt == arr.size) break
            answer++
        }

        return answer
    }
}

fun main() {
    var sol = Solution()

    var result = sol.solution(intArrayOf(2,6,8,14))

    print(result)
}