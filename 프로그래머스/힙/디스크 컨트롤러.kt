import java.util.*

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0
        var time = 0
        var waittingQueue = PriorityQueue<Job>(compareBy({it.start}))


        for(i in 0..jobs.size-1){
            var job = Job(jobs[i][0],jobs[i][1])
            waittingQueue.offer(job)
        }

        while(!waittingQueue.isEmpty()){
            var readyQueue = PriorityQueue<Job>(compareBy { it.during })
            while(!waittingQueue.isEmpty() && time>=waittingQueue.peek().start){ // 진행할 수 없다면
                readyQueue.offer(waittingQueue.poll())
            }
            if(readyQueue.isEmpty()){
                time++
                continue
            }
            time += readyQueue.peek().during
            answer += time - readyQueue.peek().start
            readyQueue.poll()

            for(i in 0..readyQueue.size-1){
                waittingQueue.offer(readyQueue.poll())
            }
        }

        answer /= jobs.size

        return answer
    }
}

data class Job(
    var start:Int = 0,
    var during:Int = 0
)
//    : Comparable<Job> {
//    override fun compareTo(other: Job): Int {
//        if (this.during > other.during) {
//            return 1
//        }
//        else if (this.during == other.during) {
//            if (this.start > other.start) {
//                return 1
//            }
//        }
//        return -1
//    }
//}

fun main(){
    var sol = Solution()
    var result= sol.solution(arrayOf(intArrayOf(1,3),intArrayOf(1,2),intArrayOf(1,1)))

    print(result)
}