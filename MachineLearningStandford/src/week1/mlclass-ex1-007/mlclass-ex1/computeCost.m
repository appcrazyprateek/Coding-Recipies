function J = computeCost(X, y, theta)
%COMPUTECOST Compute cost for linear regression
%   J = COMPUTECOST(X, y, theta) computes the cost of using theta as the
%   parameter for linear regression to fit the data points in X and y

% Initialize some useful values
m = length(y); % number of training examples

% You need to return the following variables correctly 
J = 0;

% ====================== YOUR CODE HERE ======================
% Instructions: Compute the cost of a particular choice of theta
%               You should set J to the cost.


m = length(y);
h=X * theta; % M x 2 and 2 x 1 will result into M x 1
e = h - y;    % M x 1

%eSq = e.^2;
%eSum = sum(eSq);
eSum  = e' * e ; % 1 X M and M x 1 will result into 1 x 1
J = eSum / (2*m)


% =========================================================================

end
