package leetcode

// https://leetcode.com/problems/house-robber/description/

func Rob(nums []int) int {
	if len(nums) == 0{
		return 0;
	}
	if len(nums)  <2{
		return nums[0]
	}else if len(nums) ==2{
		return Max(nums[1], nums[0])
	}
	nums[2] += nums[0]

	for i:=3;i<len(nums);i++{
		nums[i] += Max(nums[i-2], nums[i-3])
	}

	return Max(nums[len(nums)-1],nums[len(nums)-2])
}

func Max(n1 int, n2 int) int{
	if n1>n2{
		return n1
	}else{
		return n2
	}
}


func init(){
	arry := []int{1,2,3,1}
	Rob(arry)
}
