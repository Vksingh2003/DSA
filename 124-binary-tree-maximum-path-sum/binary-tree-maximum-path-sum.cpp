/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int f(TreeNode* root, int& sum){
        if (root==nullptr) return 0;
        int leftSum = f(root->left,sum);
        int rightSum = f(root->right,sum);
        int totalsum = leftSum+rightSum+root->val;
        sum = max({sum,totalsum,leftSum+root->val,rightSum+root->val,root->val});
        return max({leftSum+root->val,rightSum+root->val,root->val});
    }
    int maxPathSum(TreeNode* root) {
        int sum = INT_MIN;
        f(root,sum);
        return sum;
    }
};