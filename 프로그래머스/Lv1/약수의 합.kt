class Solution {
    fun solution(n: Int): Int {
        var answer = 0

        for(i in 1..Math.sqrt(n.toDouble()).toInt()){
            if(n%i == 0){
                if(n/i == i) answer += i
                else answer += n/i + i
            }
        }
//        answer = (1..n).filter { n % it == 0 }.sum()
        return answer
    }
}

fun main() {
    var sol = Solution()

    print(sol.solution(4))

}