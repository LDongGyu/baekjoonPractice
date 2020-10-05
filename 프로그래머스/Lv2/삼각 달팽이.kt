class Solution {
    fun solution(n: Int): IntArray {
        var answer = mutableListOf<Int>()
        var tri = Array<IntArray>(n){ it -> IntArray(it+1) }
        var num = 1
        var dir = 0
        var round = 0


        var i = 0
        var j = 0
        for(go in n downTo 1 step 1){

            if(dir == 0){
                for(h in 1..go){
                    tri[i][j] = num
                    i++
                    num++
                }
                i--
                j++
            }
            if(dir == 1) {
                for (h in 1..go) {
                    tri[i][j] = num
                    j++
                    num++
                }
                j -= 2
                i--
            }
            if(dir == 2) {
                for (h in 1..go) {
                    tri[i][j] = num
                    i--
                    j--
                    num++
                }
                i += 2
                j++
            }
            dir = (dir+1)%3
        }

        for(i in 0..n-1){
            for(j in 0..i){
                answer.add(tri[i][j])
            }
        }
        return answer.toIntArray()
    }
}

fun main() {
    var sol = Solution()

    print(sol.solution(6))
}