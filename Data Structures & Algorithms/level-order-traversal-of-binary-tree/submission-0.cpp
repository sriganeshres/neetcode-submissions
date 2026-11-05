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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()) {
            vector<int> a;
            int n = q.size();
            for(int i = 0; i < n; i++) {
                TreeNode* tp = q.front();
                q.pop();
                if(tp) {
                    a.push_back(tp->val);
                    q.push(tp->left);
                    q.push(tp->right);
                }
            }
            if(!q.empty()) {
                ans.push_back(a);
            }
        }
        return ans;
    }
};
