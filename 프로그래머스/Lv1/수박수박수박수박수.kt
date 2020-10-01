class Solution {
    fun solution(n: Int): String {
        var answer = ""
        for(i in 1..n){
            when(i%2){
                0 -> answer += '박'
                1 -> answer += '수'
            }
        }
        return answer
    }
}
//     fun solution(n: Int): String = String(CharArray(n,{i-> if(i%2==0) '수' else '박'}))

fun main() {
    var sol = Solution()

    print(sol.solution(3))

}