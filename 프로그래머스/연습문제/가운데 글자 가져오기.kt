class Solution {
    fun solution(s: String): String {
        var answer = ""
        if(s.length%2==0){
            answer = s.substring(s.length/2-1,s.length/2+1)
        }
        else{
            answer = s[s.length/2].toString()
        }
        return answer
    }
}

fun main() {
    var sol = Solution()

    var result = sol.solution("qwer")

    print(result)
}