import xlrd

# 행수만큼의 for loop 를 돌려서 행단위로 데이터를 불러와 datadict에 저장합니다.
def get_data_list(data_path):
    # 읽기 라이브러리를 통해 현재 같은 디렉터리상에 있는 test.xls를 불러와 workbook에 할당합니다.
    workbook = xlrd.open_workbook(data_path)
    # 워크북에 할당된 엑셀 데이터의 첫번째시트를 불러옵니다.
    worksheet = workbook.sheet_by_index(0)
    # nrows에 불러온 첫번째 시트의 행수를 불러옵니다.
    nrows = worksheet.nrows
    # 불러온 데이터를 저장할 딕셔너리를 선언합니다.
    data_list = []

    for row_num in range(1, nrows):
        data = {}

        # 0 : 콘텐츠 ID
        data["id"] = worksheet.cell_value(row_num, 0)
        # 2 : 콘텐츠 이름
        data["name"] = worksheet.cell_value(row_num, 2)
        # 5 : state
        data["state"] = worksheet.cell_value(row_num, 5)
        # 6 : address
        data["address"] = worksheet.cell_value(row_num,6)
        # 10 : x
        data["location_y"] = worksheet.cell_value(row_num, 10)
        # 11 : y
        data["location_x"] = worksheet.cell_value(row_num, 11)
        # 16 : telephone
        data["telephone"] = worksheet.cell_value(row_num, 16)

        # 25 ~ 34
        data["time"] = ""
        data["type"] = 0
        data["handicapped"] = 0
        data["bell"] = 0
        data["diaper"] = 0
        for i in range(25, 35, 2):
            data_type = worksheet.cell_value(row_num, i)
            data_type = str(data_type).replace(" ", "")
            if "개방시간" in data_type:
                data["time"] = worksheet.cell_value(row_num, i+1)
            
            if "소재지용도" in data_type:
                use_type = worksheet.cell_value(row_num, i+1)
                if "지하철" == use_type:
                    data["type"] = 1

            if "장애인" in data_type:
                data["handicapped"] = 1

            if "기타시설" in data_type or "기타설비" in data_type or "편의시설" in data_type:
                facility = worksheet.cell_value(row_num, i+1)

                if "벨" in facility:
                    data["bell"] = 1
                if "기저귀" in facility:
                    data["diaper"] = 1

        data_list.append(data)
    return data_list