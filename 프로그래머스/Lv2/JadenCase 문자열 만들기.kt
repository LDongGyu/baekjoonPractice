class Solution {
    fun solution(s: String): String {
        var answer = ""

        s.toLowerCase()

        answer += s[0].toUpperCase()

        for(i in 1..s.lastIndex){
            if(s[i-1] == ' '){
                answer += s[i].toUpperCase()
            }
            else{
                answer += s[i].toLowerCase()
            }
        }

        return answer
    }
}

fun main() {
    var sol = Solution()

    var result = sol.solution(" s23  TTT3t  tTT")

    print(result)
}