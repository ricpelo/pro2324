from goto_plus import goto, gotoconfig

gotoconfig(__file__)

primero = 2
ultimo = 25
i = primero
if i == ultimo: goto(12)
print(i)
i += 1
goto(8)
print('Fin')
