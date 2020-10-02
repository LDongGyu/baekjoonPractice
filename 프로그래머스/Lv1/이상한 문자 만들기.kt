class Solution {
    fun solution(s: String): String {
        var answer = ""
        var cnt = 0

        for(char in s){
            if(char == ' '){
                cnt = 0
                answer += ' '
            }
            else if(cnt%2 == 0){
                answer += char.toUpperCase()
                cnt++
            }
            else{
                answer += char.toLowerCase()
                cnt++
            }
        }

        return answer
    }
}

fun main() {
    var sol = Solution()

    print(sol.solution("try hello world"))

}