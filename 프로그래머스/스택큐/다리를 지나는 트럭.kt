import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        var weightAble = weight

        var queue:Queue<Int> = LinkedList()
        var truck:Queue<Int> = LinkedList()

        for(t in 0.. truck_weights.size-1){
            truck.add(truck_weights[t])
        }

        for(i in 0..bridge_length-1){
            queue.add(0)
        }

        while(!queue.isEmpty()){
            if(queue.peek() > 0){
                weightAble += queue.peek()
            }
            queue.poll()

            if(!truck.isEmpty()) {
                if (weightAble >= truck.peek()) {
                    weightAble -= truck.peek()
                    queue.add(truck.poll())
                } else {
                    queue.add(0)
                }
            }
            answer++
        }
        return answer
    }
}

fun main(){
    var sol = Solution()
    var result= sol.solution(2,10,intArrayOf(7,4,5,6))

    print(result)
}