class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var aNum = a
        var bNum = b

        while(aNum != bNum){
            aNum = (aNum+1)/2
            bNum = (bNum+1)/2
            answer++
        }

        return answer
    }
}

fun main() {
    var sol = Solution()

    var result = sol.solution(8,2,3)
    // 8,2,3 8,4,7

    print(result)
}