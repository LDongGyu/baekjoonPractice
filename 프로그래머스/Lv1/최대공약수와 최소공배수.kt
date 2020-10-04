class Solution {
    fun solution(n: Int, m: Int): IntArray {
        var answer = IntArray(2)

        // 최대 공약수
        var gcd = Math.min(m,n)
        while(true){
            if(n%gcd == 0 && m%gcd == 0){
                answer[0] = gcd
                break
            }
            gcd--
        }

        // 최소 공배수
        var lcm = Math.max(n,m)
        while(true){
            if(lcm%n == 0 && lcm%m == 0){
                answer[1] = lcm
                break
            }
            lcm++
        }

        return answer
    }
}

fun main() {
    var sol = Solution()

    print(sol.solution(3,12))
}