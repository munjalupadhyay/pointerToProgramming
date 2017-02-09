bool struct fun(struct node *t,int* min,int* max){

	int leftMin,leftMax;
	int rightMin,rightMax;
	bool leftBool,rightBool;
	
	if(t->left == NULL){
		leftMin=leftMax=t->data;
		leftBool=true;
	}
	else{
		leftBool=fun(t->left,&leftMin,&leftMax);
	}
	
	if(t->right == NULL){
		rightMin=rightMax=t->data;
		rightBool=true;
	}
	else{
		rightBool=fun(t->right,&rightMin,&rightMax);
	}
	
	if(leftBool && rightBool
		&& leftMin<= t.data
		&& leftMax <= t.data
		&& rightMin >= t.data
		&& rightMax >= t.data){
		*min=leftMin;
		*max=rightMax;
		return true;
	}
	
	return false;


}
