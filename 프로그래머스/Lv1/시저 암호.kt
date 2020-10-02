class Solution {
    fun solution(s: String, n: Int): String {
        var answer = ""

        s.forEach {
            if(it == ' ') answer += ' '
            else if(it >= 'a' && it <= 'z'){
                if(it+n > 'z') answer += it+n-26
                else answer += it+n
            }
            else{
                if(it+n > 'Z') answer += it+n-26
                else answer += it+n
            }
        }

        return answer
    }
}

fun main() {
    var sol = Solution()

    print(sol.solution("AB",1))

}