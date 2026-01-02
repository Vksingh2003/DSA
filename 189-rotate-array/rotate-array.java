class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        Reverse(nums,0,n-1);
        Reverse(nums,0,k-1);
        Reverse(nums,k,n-1);

    }
    public void Reverse(int arr[],int s, int e){
        while(e>s){
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
    }
}