a.
Code:
int sum = 0;
for (int n = N; n > 0; n /= 2)
for (int i = 0; i < n; i++) sum++;

Phan tich:

Vong lap ngoai: n giam mot nua sau moi buoc, nhan cac gia tri N, N/2, N/4, ..., 1.

Vong lap trong: chay n lan cho moi gia tri cua n.

Tong so lan tang bien sum la: N + N/2 + N/4 + ... + 1, xap xi bang 2N.

Ket luan: Bac tang thoi gian chay la O(N) (hoac ~N).

b.
Code:
int sum = 0;
for (int i = 1; i < N; i *= 2)
for (int j = 0; j < i; j++) sum++;

Phan tich:

Vong lap ngoai: i nhan gap doi sau moi buoc (i = 1, 2, 4, 8, ... < N).

Vong lap trong: chay i lan cho moi gia tri cua i.

Tong so lan tang bien sum la: 1 + 2 + 4 + 8 + ... + 2^k, nho hon 2N.

Ket luan: Bac tang thoi gian chay la O(N) (hoac ~N).

c.
Code:
int sum = 0;
for (int i = 1; i < N; i *= 2)
for (int j = 0; j < N; j++) sum++;

Phan tich:

Vong lap ngoai: i nhan gap doi moi buoc, so lan lap la log2(N).

Vong lap trong: luon chay co dinh N lan.

Tong so lan tang bien sum la: N * log2(N).

Ket luan: Bac tang thoi gian chay la O(N log N) (hoac ~N log2 N).