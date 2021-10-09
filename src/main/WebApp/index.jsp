<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<!--
Студент,	 выполнивший работу: Степанов Михаил Алексеевич
Группа: P3230
Вариант: 30015
-->
<head>
	<meta charset="UTF-8">
	<link rel="icon" href="img/tab-icon.ico">
	<link rel="stylesheet" type="text/css" href="styles/style.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<title>Web-lab 2</title>
</head>

<body>
	<script src="scripts/jokes.js"></script>
	<table id="main-grid">
		<tr>
			<td id="header-title" colspan="2">
				<center id="header-text" class="left-aligned">
					Студент: Степанов Михаил Алексеевич<br>
					Группа: P3230<br>
					Вариант: 30015
				</center>
			</td>
			<td id="header-joke">
				<button id="button-joke" onclick="joke()">Хочу анекдот</button>
			</td>
		</tr>
		<tr>
			<td id="content-graph">
				<center>
					<canvas id="graph" width="300" height="300">Обновите браузер</canvas>
				</center>
			</td>
			<td id="content-form">
				<form id="input-form">
					<fieldset>
						<legend><span id="legend-text">Проверьте вашу точку</span></legend>
						<table>
							<!-- X-input field -->
							<tr class="label-col">
								<td rowspan="2" class="input-grid-label">
									<label class="bold-label">X[-3..5]: </label>
								</td>
							</tr>
							<tr>
								<td>
									<input name="x" id="xtextinput" type="text" class="number1" data-min="-3" data-max="5" data-separator=",">
								</td>
							</tr>
							
							<!-- Y-input field -->
							<tr class="label-col">
								<td rowspan="2" class="input-grid-label">
									<label class="bold-label">Y[-3..5]: </label>
								</td>
							</tr>
							<tr>
								<td>
									<input name="y" id="ytextinput" type="text" class="number2" data-min="-3" data-max="5" data-separator=",">
								</td>
							</tr>
							
							<!-- R-input field -->
							<tr class="label-col">
								<td rowspan="2" class="input-grid-label">
									<label class="bold-label">R: </label>
								</td>
							</tr>
							<tr>
								<td>
								<!-- There are a few checkbox fields that contained in one row of a table -->
									<table class="nopadding">
										<tr class="nopadding">
											<td class="rcheckbox">
												<label>
													<input type="checkbox" class="input-checkbox" id="rcheckbox1" value="1">
													<span>1</span>
												</label>
											</td>
											<td class="rcheckbox">
												<label>
													<input type="checkbox" class="input-checkbox" id="rcheckbox2" value="2">
													<span>2</span>
												</label>
											</td>
											<td class="rcheckbox">
												<label>
													<input type="checkbox" class="input-checkbox" id="rcheckbox3" value="3">
													<span>3</span>
												</label>
											</td>
											<td class="rcheckbox">
												<label>
													<input type="checkbox" class="input-checkbox" id="rcheckbox4" value="4">
													<span>4</span>
												</label>
											</td>
											<td class="rcheckbox">
												<label>
													<input type="checkbox" class="input-checkbox" id="rcheckbox5" value="5" checked>
													<span>5</span>
												</label>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<input name='form' id="forsubmit" class="button-form" type="button" value="Проверить" onclick="startPHP()">
						<input id="forreset" class="button-form" type="reset" value="Сбросить">
					</fieldset>
				</form>
			</td>
			<td id="answer">
				<center id="textwindow">
					Жду команды!
				</center>
			</td>
		</tr>
		<tr>
			<td colspan="3" id="history-td">
				Таблица результатов
			</td>
		</tr>
		<tr>
			<td colspan="3" id="historyRow">
				<table id="historyBrowser">
				</table>
			</td>
		</tr>
		<tr>
			<td id="footer-title" colspan="2">
				<center class="center-aligned">Если возникли вопросы пишите нам на почту или обращайтесь по номеру телефона<br>
				+7 (800) 555-35-35<br>
				noreply@codeforces.com</center>
			</td>
			<td id="footer-logo">
				<center><img src="img/itmo.png" id="img-logo"></center>
			</td>
		</tr>
	</table>
	<script src="scripts/valid.js?v=26"></script>
	<script src="scripts/graph.js"></script>
</body>

</html>