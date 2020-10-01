class Solution {
    fun solution(s: String): Boolean {

        if(s.length == 4 || s.length == 6){
            for(char in s){
                if(!(char >= '0' && char <= '9')) return false
            }
            return true
        }
        else return false
    }
}
//         val length = s.filter { it.isDigit() }.length
fun main() {
    var sol = Solution()

    print(sol.solution("11111"))

}